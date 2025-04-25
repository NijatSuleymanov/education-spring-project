package com.influencer.education.dto;


import com.influencer.education.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {


   StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class) ;

   StudentDTO  toDto(Student student);
   Student toEntity(StudentDTO dto);
}
