package pkg1.friends;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class FriendController {
	@Autowired
	FriendRepo fr;
	
	@PostMapping("/friend/add")
	public FriendEntity addFriend(@RequestBody FriendEntity fe) {
		return fr.save(fe);
	}
	
	@GetMapping("/friend/findAll")
	public List<FriendEntity> findAllFriends(){
		return fr.findAll();
	}
	
	@GetMapping("/friend/find/{id}")
	public Optional<FriendEntity> findFriendById(@PathVariable int id){
		return fr.findById(id);
	}
	
	@GetMapping("/friend/find")
	public Optional<FriendEntity> findFriend(@RequestParam int id){
		return fr.findById(id);
	}
	
	@DeleteMapping("/friend/clearFriendList")
	public String deleteAllFriends() {
		fr.deleteAll();
		return "Successfully Cleared List";
	}
	
	@DeleteMapping("/friend/clearFriend/{id}")
	public String deleteFriendById(@PathVariable int id) {
		try {
			fr.deleteById(id);
			return "Successfully Cleared " + id +" from the List";
		}
		catch(Exception e){
			return "Id:"+id+" not found";
		}		
	}
	
//	@PutMapping("/friend/updateFriend/{id}")
//	public Optional<FriendEntity> updateFriendById(@PathVariable int id,@RequestBody FriendEntity fe){
//		return fr.save(fe);
//	}
}
