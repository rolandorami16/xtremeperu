package com.proyecto.xtreme.entidades;

import javax.persistence.*;
@Entity
@Table(name = "TP_CLIENTE")
public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long codigo;
        private String nombre;
        private String apellido;
        private Long dni;
        private String mail;
        private String password;
        private String direccion;
        private String departamento;
        private  boolean sexo;
        private String fecha_nacimiento;

        public String getDireccion() {
            return direccion;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public String getDepartamento() {
            return departamento;
        }

        public void setDepartamento(String departamento) {
            this.departamento = departamento;
        }

        public boolean isSexo() {
            return sexo;
        }

        public void setSexo(boolean sexo) {
            this.sexo = sexo;
        }

        public String getFecha_nacimiento() {
            return fecha_nacimiento;
        }

        public void setFecha_nacimiento(String fecha_nacimiento) {
            this.fecha_nacimiento = fecha_nacimiento;
        }

        public Long getCodigo() {
            return codigo;
        }

        public void setCodigo(Long codigo) {
            this.codigo = codigo;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }

        public Long getDni() {
            return dni;
        }

        public void setDni(Long dni) {
            this.dni = dni;
        }

        public String getMail() {
            return mail;
        }

        public void setMail(String mail) {
            this.mail = mail;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
}


