package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.models.Body_Model;
import com.companyKLJ.hexagonal.domain.repositories.SaveBody_ModelRepository;
import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class SaveBody_AdapterRepository implements SaveBody_ModelRepository {

    private final Body_PortRepositoryJPA body_portRepositoryJPA;

    private SaveBody_AdapterRepository(Body_PortRepositoryJPA bodyPortRepositoryJPA) {
        body_portRepositoryJPA = bodyPortRepositoryJPA;
    }
    public static SaveBody_AdapterRepository init(Body_PortRepositoryJPA bodyPortRepositoryJPA){
        return new SaveBody_AdapterRepository(bodyPortRepositoryJPA);
    }


    @Override
    public Body_Model save(Body_Model body) {
        Body_Entity entity = null;
        //ContentType contentType;
        //ColorsType colorsType;
        //Header_Model registro;
        Optional<Body_Model> dataExistenceValidation = Optional.ofNullable(body);
        if (dataExistenceValidation.isPresent()) {
            //contentType = (ContentType)header.getContentTypeEnum();
            //colorsType = (ColorsType)header.getColorsTypeEnum();
            entity = Body_Entity.init().builder()
                    .id(dataExistenceValidation.get().getId())
                    .idHeader_Model(dataExistenceValidation.get().getIdHeader_Model().getId())
                    .bodyNote(dataExistenceValidation.get().getBodyNote())
                    .noReference(dataExistenceValidation.get().getNoReference())
                    .crationDate(LocalDate.now())
                    .crationTime(LocalTime.now())
                    .creationLocalDateTime(LocalDateTime.now())
                    .build();
            this.body_portRepositoryJPA.save(entity);
            body.setId(entity.getId());
            body.setCrationDate(entity.getCrationDate());
            body.setCrationTime(entity.getCrationTime());
            body.setCreationLocalDateTime(entity.getCreationLocalDateTime());


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


        return body;
    }
}
