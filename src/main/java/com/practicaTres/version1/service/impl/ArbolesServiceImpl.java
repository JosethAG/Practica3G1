
package com.practicaTres.version1.service.impl;
import com.practicaTres.version1.dao.ArbolesDao;
import com.practicaTres.version1.domain.Arboles;
import com.practicaTres.version1.service.ArbolesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolesServiceImpl implements ArbolesService {

    @Autowired
    private ArbolesDao arbolesDao;

    @Override
    @Transactional(readOnly = true)
    public List<Arboles> getArboles(boolean activos) {
        var lista = arbolesDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Arboles getArboles(Arboles arboles) {
        return arbolesDao.findById(arboles.getIdArboles()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Arboles arboles) {
        arbolesDao.save(arboles);
    }

    @Override
    @Transactional
    public void delete(Arboles arboles) {
        arbolesDao.delete(arboles);
    }
}
