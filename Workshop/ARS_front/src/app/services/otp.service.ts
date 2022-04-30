import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OtpService {

  baseurl="http://localhost:8080";
  constructor(private _http:HttpClient) { }

  sendOtp(contact:any):Observable<any>{
    return this._http.post(this.baseurl+'/sendotp',contact);
  }

  verifyOtp(otpCredential:any):Observable<any>{
    return this._http.post(this.baseurl+'/verifyotp',otpCredential);
  
  }
}
