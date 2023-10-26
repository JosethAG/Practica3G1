package com.practicaTres.version1.service;

import com.practicaTres.version1.domain.Arboles;
import java.util.List;

public interface ArbolesService {
    
    // Se obtiene un listado de categorias en un List
    public List<Arboles> getArboles(boolean activos);
    
   // Se obtiene un Arbol, a partir del id de un categoria
    public Arboles getArboles(Arboles arboles);
    
    // Se inserta un nuevo arbol si el id del arbol esta vacío
    // Se actualiza un arbol si el id del arbol NO esta vacío
    public void save(Arboles arboles);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Arboles arboles);
}