package com.corona.insertrecords.service;

import com.corona.insertrecords.entity.RequestDto;
import com.corona.insertrecords.entity.ResponseDto;

import java.io.IOException;

public interface IParametry {

    ResponseDto executeInsertParametries(RequestDto requestDto) throws IOException;

}
