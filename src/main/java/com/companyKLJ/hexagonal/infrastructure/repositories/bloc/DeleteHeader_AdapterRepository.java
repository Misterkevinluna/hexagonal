package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.domain.repositories.DeleteHeader_ModelRepository;

public class DeleteHeader_AdapterRepository implements DeleteHeader_ModelRepository {
    private final Header_PortRepositoryJPA header_portRepositoryPanache;

    private DeleteHeader_AdapterRepository(Header_PortRepositoryJPA headerPortRepositoryPanache) {
        header_portRepositoryPanache = headerPortRepositoryPanache;
    }
    public static DeleteHeader_AdapterRepository init(Header_PortRepositoryJPA headerPortRepositoryPanache){
        return new DeleteHeader_AdapterRepository(headerPortRepositoryPanache);
    }

    // NOTA: TENER EN CUENTA CREAR UN METODO TELETE QUE ELIMINE PASANDOLE EL OBJETO COMPLETO
    /*
        if (header_portRepositoryPanache.existsById(id)) {
            List<Body_Model> eliminarBody = getAllBody_adapterRepository.getAll();
            eliminarBody.stream().filter(idIguales ->  (Objects.equals(idIguales.getIdHeader_Model().getId(), id)))
                    .forEach(a -> {
                        deleteBody_adapteRepository.deleteById(a.getId());
                    });
            header_portRepositoryPanache.deleteById(id);
            return true;
        }
    * */
    @Override
    public boolean delete(Long id) {
        if (header_portRepositoryPanache.existsById(id)) {
            header_portRepositoryPanache.deleteById(id);
            return true;
        }
        return false;
    }

    /*@Override
    public boolean deleteNoReference(String noReference) {
        return false;
    }*/
}
