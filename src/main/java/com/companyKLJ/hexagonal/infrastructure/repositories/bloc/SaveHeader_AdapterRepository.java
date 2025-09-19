package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Header_Model;
import com.companyKLJ.hexagonal.domain.models.enums.ColorsType;
import com.companyKLJ.hexagonal.domain.models.enums.ContentType;
import com.companyKLJ.hexagonal.domain.repositories.SaveHeader_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Header_Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class SaveHeader_AdapterRepository implements SaveHeader_ModelRepository {
    private final Header_PortRepositoryJPA header_portRepositoryPanache;

    private SaveHeader_AdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache) {
        header_portRepositoryPanache = headerPortRepositoryPanache;
    }

    public static SaveHeader_AdapterRepository init(Header_PortRepositoryJPA headerPortRepositoryPanache) {
        return new SaveHeader_AdapterRepository(headerPortRepositoryPanache);
    }

    @Override
    public Header_Model save(Header_Model header) {
        Header_Entity entity = null;
        //ContentType contentType;
        //ColorsType colorsType;
        //Header_Model registro;
        Optional<Header_Model> dataExistenceValidation = Optional.ofNullable(header);
        if (dataExistenceValidation.isPresent()) {
            //contentType = (ContentType)header.getContentTypeEnum();
            //colorsType = (ColorsType)header.getColorsTypeEnum();
            entity = Header_Entity.init().builder()
                    .id(dataExistenceValidation.get().getId())
                    .titleNote(dataExistenceValidation.get().getTitleNote())
                    .introNote(dataExistenceValidation.get().getIntroNote())
                    .contentTypeEnum(dataExistenceValidation.get().getContentTypeEnum().getTypeContent())
                    .colorsTypeEnum(dataExistenceValidation.get().getColorsTypeEnum().getColor())
                    .noReference(dataExistenceValidation.get().getNoReference())
                    .crationDate(LocalDate.now())
                    .crationTime(LocalTime.now())
                    .creationLocalDateTime(LocalDateTime.now())
                    .build();
            this.header_portRepositoryPanache.save(entity);
            header.setId(entity.getId());
            header.setCrationDate(entity.getCrationDate());
            header.setCrationTime(entity.getCrationTime());
            header.setCreationLocalDateTime(entity.getCreationLocalDateTime());


            /*registro = HeaderMapper.INSTANCE.toDomain(this.header_portRepositoryPanache.findById(entity.getId()));
            String comprobante = registro != null?
                    "---------------------------- PROCESO DE RESGISTRO --------------------------\n" +
                            "\nEXITOSO!!\n" +
                            "\n-----------------------------------------------------------------------------"
                    :
                    "\nREGISTRO FALLIDO\n" +
                            "\n--------------------------------------------------------------------------------------";
            System.out.println(comprobante);*/
        }else {
            //throw CustomException.call("OBJETO NULO", "Validación de Existencia de Datos es NULL");
            System.out.println("-----------------------------------------------------------------------------------------\n" +
                    "\n--------------------------------------- OBJETO NULO ------------------------------------------------\n" +
                    "Validación de Existencia de Datos es NULL\n" +
                    "\n---------------------------------------------------------------------------------------------------------");
        }


        return header;
    }

}
