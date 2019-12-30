/**
 * 
 * Created By Esmelealem m. : 10/5/2019
 */
package com.BookStore.Repository;

import org.springframework.data.repository.CrudRepository;

import com.BookStore.Domain.Security.Role;

/**
 * @author User
 *
 */
public interface RoleRepository extends CrudRepository<Role, Long>{
	

}
