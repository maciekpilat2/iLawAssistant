/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import app.models.Address;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Pilat
 */
@Repository
public interface AddressRepository extends CrudRepository<Address, Long>{
    
        @Query("select a.streetNumber, a.streetName, a.city, a.administrativeArea, a.postalCode, a.country, a.addressType from Address a where a.person.id=?1")
    List<Address> allClientAddress(Long clientId);
    
    List<Address> findAddressByPersonId(Long clientId);
    
}