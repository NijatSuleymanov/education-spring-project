package com.influencer.education.student.dto;


import com.influencer.education.student.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StudentMapper {


   StudentMapper MAPPER = Mappers.getMapper(StudentMapper.class) ;

   StudentDTO  toDto(Student student);
   Student toEntity(StudentDTO dto);
}
