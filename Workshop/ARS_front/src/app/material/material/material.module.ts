import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input'


const material = [
  MatFormFieldModule,
  MatSelectModule,
  MatInputModule
]
 
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    material

  ],exports: [material]
})
export class MaterialModule { }
