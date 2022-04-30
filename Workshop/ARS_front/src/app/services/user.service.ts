import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../utilities/user';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }
  
  baseurl="http://localhost:8081/user";
  
public getAll() {
    return this.http.get<User[]>('/getAllUsers');
}

public loginUser(user:User):Observable<any>{
  return this.http.post<any>(this.baseurl+'/login',user); 
}

public registerUser(user:User):Observable<any>{
  return this.http.post<any>(this.baseurl+'/register',user); 
}


}
