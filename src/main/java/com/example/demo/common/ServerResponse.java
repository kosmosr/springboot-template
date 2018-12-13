package com.example.demo.common;

import com.example.demo.dto.CodeErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author kosmosr
 * @date 2018-10-25 18:38
 **/
public class ServerResponse<T> extends ResponseEntity<T> {
    private ServerResponse(HttpStatus status) {
        super(status);
    }

    private ServerResponse(T body) {
        super(body, HttpStatus.OK);
    }

    private ServerResponse(T body, HttpStatus status) {
        super(body, status);
    }

    /**
     * 直接返回空，http状态码为200
     *
     * @param <T> T
     * @return null
     */
    public static <T> ServerResponse<T> success() {
        return new ServerResponse<>(HttpStatus.OK);
    }

    /**
     * 返回具体数据，http状态码为200
     *
     * @param data 具体数据
     * @param <T>  泛型
     * @return data
     */
    public static <T> ServerResponse<T> success(T data) {
        return new ServerResponse<>(data);
    }

    public static <T> ServerResponse<T> error(HttpStatus status) {
        return new ServerResponse<>(status);
    }

    public static <T> ServerResponse<T> error(T data, HttpStatus status) {
        return new ServerResponse<>(data, status);
    }

    public static ServerResponse<CodeErrorDTO> errorHttp(CodeErrorDTO dto) {
        HttpStatus httpStatus;
        if (dto.getErrorCode().toString().length() > 3) {
            httpStatus = HttpStatus.valueOf(Integer.parseInt(dto.getErrorCode().toString().substring(0, 3)));
        } else {
            httpStatus = HttpStatus.valueOf(dto.getErrorCode());
        }
        return new ServerResponse<>(dto, httpStatus);
    }
}
