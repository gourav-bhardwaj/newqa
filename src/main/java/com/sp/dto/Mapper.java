package com.sp.dto;

public interface Mapper<M, D> {

	D modelToDtoMapper(M model);
	M dtoToModelMapper(D dto);
	
}
