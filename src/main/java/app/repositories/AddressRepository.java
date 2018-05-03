/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import app.models.Address;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Pilat
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
    
}
