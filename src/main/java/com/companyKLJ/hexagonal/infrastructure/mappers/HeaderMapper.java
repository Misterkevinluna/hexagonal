package com.companyKLJ.hexagonal.infrastructure.mappers;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.models.enums.ColorsType;
import com.companyKLJ.hexagonal.domain.models.enums.ContentType;
import com.companyKLJ.hexagonal.infrastructure.entities.Header_Entity;

public class HeaderMapper {

    public static Header_Model toDomain(Header_Entity entity){

        return Header_Model.init(entity.getId(), entity.getTitleNote(), entity.getIntroNote(), Header_Model.init().setContentTypeEnumByString(entity.getContentTypeEnum()),
                Header_Model.init().setColorsTypeEnumByString(entity.getColorsTypeEnum()), entity.getNoReference(), entity.getCrationDate(), entity.getCrationTime(),
                entity.getCreationLocalDateTime());
    }

    public static Header_Entity toEntity(Header_Model model){
        return new Header_Entity().init().builder().id(model.getId())
                .titleNote(model.getTitleNote())
                .titleNote(model.getIntroNote())
                .noReference(model.getNoReference())
                .contentTypeEnum(model.getContentTypeEnum().name())
                .colorsTypeEnum(model.getColorsTypeEnum().name())
                .crationDate(model.getCrationDate())
                .crationTime(model.getCrationTime())
                .creationLocalDateTime(model.getCreationLocalDateTime())
                .build();
    }

    /*public static Enum<ContentType> getContentTypeEnumString(String typeContent){
        Enum<ContentType> contentTypeEnum = Header_Model.init().setContentTypeEnumByString(typeContent);
        System.out.println("------------------------------------------------ llego al mapper getContentTypeEnumString\n" +
                "\n"+ contentTypeEnum.name());
        return contentTypeEnum;
    }*/
    /*public static Enum<ColorsType> getaColorTypeEnumString(String typeColor){
        Enum<ColorsType> colorsTypeEnum = Header_Model.init().setColorsTypeEnumByString(typeColor);
        System.out.println("------------------------------------------------ llego al mapper getaColorTypeEnumString\n" +
                "\n"+ colorsTypeEnum.name());
        return colorsTypeEnum;
    }*/
}
