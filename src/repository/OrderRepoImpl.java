package repository;

import common.Order.OrderIdGenerator;
import config.DBUtil;
import dto.orderDTO.OrderStatisticsDTO;
import vo.orderVO.OrderDetailVO;
import vo.orderVO.OrderVO;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class OrderRepoImpl implements OrderRepo {

    @Override
    public String saveOrder(OrderVO order) {
        // OrderId를 생성한 후 테이블의 실제 컬럼(orderId, orderDate, orderStatus, memberId)만 삽입
        String newOrderId = OrderIdGenerator.generateOrderId();
        String sql = "INSERT INTO `Order` (orderId, orderDate, orderStatus, memberId) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, newOrderId);
            pstmt.setDate(2, Date.valueOf(order.getOrderDate()));
            pstmt.setString(3, order.getOrderStatus());
            pstmt.setString(4, order.getMemberId());
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No rows affected");
            }
            return newOrderId;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void saveOrderDetail(OrderDetailVO detail) {
        // orderDetailId는 AUTO_INCREMENT 이므로 명시하지 않고 나머지 컬럼만 삽입
        String sql = "INSERT INTO OrderDetail (orderQuantity, productId, orderId) VALUES (?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, detail.getOrderQuantity());
            pstmt.setString(2, detail.getProductId()); // productId를 String으로 설정
            pstmt.setString(3, detail.getOrderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public OrderVO findOrderById(String orderId) {
        String sql = "SELECT orderId, orderDate, orderStatus, memberId FROM `Order` WHERE orderId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new OrderVO(
                            rs.getString("orderId"),
                            rs.getDate("orderDate").toString(),
                            rs.getString("orderStatus"),
                            rs.getString("memberId")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrder(OrderVO order) {
        String sql = "UPDATE `Order` SET orderDate = ?, orderStatus = ?, memberId = ? WHERE orderId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(order.getOrderDate()));
            pstmt.setString(2, order.getOrderStatus());
            pstmt.setString(3, order.getMemberId());
            pstmt.setString(4, order.getOrderId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderDetailVO> findOrderDetailsByOrderId(String orderId) {
        List<OrderDetailVO> details = new ArrayList<>();
        String sql = "SELECT orderDetailId, orderQuantity, productId, orderId FROM OrderDetail WHERE orderId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, orderId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    details.add(new OrderDetailVO(
                            rs.getInt("orderDetailId"),
                            rs.getInt("orderQuantity"),
                            rs.getString("productId"), // productId를 String으로 읽음
                            rs.getString("orderId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return details;
    }

    @Override
    public List<OrderVO> findOrdersByStatus(String status) {
        List<OrderVO> orders = new ArrayList<>();
        String sql = "SELECT orderId, orderDate, orderStatus, memberId FROM `Order` WHERE orderStatus = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderVO(
                            rs.getString("orderId"),
                            rs.getDate("orderDate").toString(),
                            rs.getString("orderStatus"),
                            rs.getString("memberId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<OrderVO> findOrdersByFranchiseId(String franchiseId) {
        // franchiseId는 Order 테이블의 memberId 컬럼과 매핑됨
        List<OrderVO> orders = new ArrayList<>();
        String sql = "SELECT orderId, orderDate, orderStatus, memberId FROM `Order` WHERE memberId = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, franchiseId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderVO(
                            rs.getString("orderId"),
                            rs.getDate("orderDate").toString(),
                            rs.getString("orderStatus"),
                            rs.getString("memberId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<OrderVO> findOrdersByDate(String date) {
        List<OrderVO> orders = new ArrayList<>();
        String sql = "SELECT orderId, orderDate, orderStatus, memberId FROM `Order` WHERE orderDate = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(date));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderVO(
                            rs.getString("orderId"),
                            rs.getDate("orderDate").toString(),
                            rs.getString("orderStatus"),
                            rs.getString("memberId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<OrderVO> findOrdersByDateRange(String startDate, String endDate) {
        List<OrderVO> orders = new ArrayList<>();
        String sql = "SELECT orderId, orderDate, orderStatus, memberId FROM `Order` WHERE orderDate BETWEEN ? AND ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, Date.valueOf(startDate));
            pstmt.setDate(2, Date.valueOf(endDate));
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    orders.add(new OrderVO(
                            rs.getString("orderId"),
                            rs.getDate("orderDate").toString(),
                            rs.getString("orderStatus"),
                            rs.getString("memberId")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public OrderStatisticsDTO getOrderStatisticsByFranchiseAndMonth(String franchiseId, int year, int month) {
        int totalOrderRequests = 0;
        Map<String, Integer> productStats = new HashMap<>();
        String monthStr = (month < 10 ? "0" + month : String.valueOf(month));
        String pattern = year + "-" + monthStr + "-%";
        String sqlCount = "SELECT COUNT(*) AS orderCount FROM `Order` WHERE memberId = ? AND orderDate LIKE ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCount)) {
            pstmt.setString(1, franchiseId);
            pstmt.setString(2, pattern);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    totalOrderRequests = rs.getInt("orderCount");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // OrderDetail과 조인하여 각 productId별 총 주문 수량을 집계
        String sqlProduct = "SELECT OD.productId, SUM(OD.orderQuantity) AS totalQuantity " +
                "FROM OrderDetail OD JOIN `Order` O ON OD.orderId = O.orderId " +
                "WHERE O.memberId = ? AND O.orderDate LIKE ? GROUP BY OD.productId";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlProduct)) {
            pstmt.setString(1, franchiseId);
            pstmt.setString(2, pattern);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    String productId = rs.getString("productId");
                    int totalQuantity = rs.getInt("totalQuantity");
                    productStats.put(productId, totalQuantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new OrderStatisticsDTO(totalOrderRequests, productStats);
    }

    @Override
    public Map<String, Integer> getPendingOrderQuantities() {
        Map<String, Integer> pendingMap = new HashMap<>();
        String sql = "SELECT OD.productId, SUM(OD.orderQuantity) AS totalPending " +
                "FROM OrderDetail OD JOIN `Order` O ON OD.orderId = O.orderId " +
                "WHERE O.orderStatus = '발주 승인 대기중' GROUP BY OD.productId";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                String productId = rs.getString("productId");
                int totalPending = rs.getInt("totalPending");
                pendingMap.put(productId, totalPending);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingMap;
    }

    @Override
    public OrderStatisticsDTO getLastMonthOrderStatistics(String franchiseId) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        int lastMonth = cal.get(Calendar.MONTH) + 1;
        int lastYear = cal.get(Calendar.YEAR);
        return getOrderStatisticsByFranchiseAndMonth(franchiseId, lastYear, lastMonth);
    }
}
