package common.util;

import dto.memberDTO.MemberDTO;

import java.util.List;
import java.util.Optional;

public class OutputUtil {

    public static  <T> void output(T result){
        System.out.println(result);
    }


    public static <T> void outputList(List<T> result){
        result.forEach(System.out::println);
    }
}
