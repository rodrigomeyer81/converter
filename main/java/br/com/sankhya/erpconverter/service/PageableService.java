package br.com.sankhya.erpconverter.service;

import br.com.sankhya.erpconverter.entity.Pageable;
import br.com.sankhya.erpconverter.entity.ResponseConverter;
import org.springframework.stereotype.Service;

@Service
public final class PageableService {

    public static Pageable createPageable(ResponseConverter responseConverter){

        return createPageable(responseConverter.getOffsetPage(),
                responseConverter.getOffset(),
                responseConverter.getTotal());

    }


    public static Pageable createPageable(int page, int elementsPerPage, int totalElements){

        int totalPage = calculateTotalPage(page, elementsPerPage);

        boolean hasNext = calculateHasNext(page, totalPage);

        return new Pageable(page, elementsPerPage, hasNext, totalPage, totalElements);
    }


    private static boolean calculateHasNext(int page, int pageSize){

        if(pageSize > page){

            return true;

        }else {

            return false;
        }
    }


    private static int calculateTotalPage(int size, int totalElements){

        int response = 0;

        if (totalElements != 0) {

            response = (int) Math.ceil(size / totalElements);
        }
        return response;
    }
}
