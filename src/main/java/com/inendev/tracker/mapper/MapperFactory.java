package com.inendev.tracker.mapper;

public interface MapperFactory<E, DTO> {
    Mapper<E, DTO> getForSingle();

    Mapper<E, DTO> getForMultiple();
}
