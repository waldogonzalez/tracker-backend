package com.inendev.tracker.mapper;

public interface Mapper<E, DTO> {
    DTO map(E entity);
}
