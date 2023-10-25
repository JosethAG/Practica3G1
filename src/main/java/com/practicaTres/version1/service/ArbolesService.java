
package com.practicaTres.version1.service;
import com.practicaTres.version1.domain.Arboles;
import java.util.List;

public interface ArbolesService {
    
    // Se obtiene un listado de categorias en un List
    public List<Arboles> getArboles(boolean activos);
    
   // Se obtiene un Categoria, a partir del id de un categoria
    public Arboles getArboles(Arboles arboles);
    
    // Se inserta un nuevo categoria si el id del categoria esta vacío
    // Se actualiza un categoria si el id del categoria NO esta vacío
    public void save(Arboles arboles);
    
    // Se elimina el categoria que tiene el id pasado por parámetro
    public void delete(Arboles arboles);
}