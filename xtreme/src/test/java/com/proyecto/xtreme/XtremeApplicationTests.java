package com.proyecto.xtreme;

import com.proyecto.xtreme.entidades.Actividad;
import com.proyecto.xtreme.entidades.Empresa;
import com.proyecto.xtreme.entidades.Registro;
import com.proyecto.xtreme.negocio.NegocioActividad;
import com.proyecto.xtreme.negocio.NegocioEmpresa;
import com.proyecto.xtreme.negocio.NegocioRegistro;
import com.proyecto.xtreme.repositorio.EmpresaRepositorio;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
@AutoConfigureTestEntityManager
@Rollback(false)
public class XtremeApplicationTests {
	@Autowired
	private TestEntityManager entityManager;
	@Autowired
	private NegocioEmpresa negocioEmpresa;
	@Autowired
	private NegocioActividad negocioActividad;
	@Autowired
	private NegocioRegistro negocioRegistro;
	@Test
	public void contextLoads() {
	}

	@Test
	public void probrarRegistrarEmpresa(){
		Empresa empresa = new Empresa();
		empresa.setRazonSocial("Extrem Huancayo S.A.");
		empresa.setNombreComercial("Huancayo Extremo");
		empresa.setRuc("20157985726");
		empresa.setCorreoinfo("contacto@extremo.com");
		empresa.setTelefono("4789635");
		empresa.setWeb("www.extremojunin.com");
		empresa.setDireccion("Av. Los lirios 369");
		empresa.setDepartamento("Junin");
		empresa.setProvincia("Huancayo");
		empresa.setDistrito("El Tambo");
		negocioEmpresa.crearEmpresa(empresa);
	}

	@Test
	public void probrarRegistrarActividad(){
		Actividad actividad = new Actividad();
		actividad.setNombreDescriptivo("canotaje");
		negocioActividad.crearActividad(actividad);
	}

	@Test
	public void ingresarRegistro(){
	Registro registro=new Registro();
	registro.setNombreRegistro("Canotaje Rio mayo");
	registro.setDescripcion("Una emocionante experiencia ");
	registro.setProvincia("Lamas");
	registro.setTelefono("2958526");
	registro.setHorario("9:00 A.M.");
	registro.setCupos(3);
	registro.setItinerario("Inicio 9:00 PM - recojo en Hotel - descenso en el rio - dura 60 min");
	registro.setDistrito("Lamas");
	registro.setPrecio(250.00);
	Registro r;
	r = negocioRegistro.crearRegistro("20157985726","canotaje",registro);
	Assert.assertNotNull(r);
	}

	/*
	@Test
	public void ingresarActividad(){
		Actividad actividad=new Actividad();
		actividad.setNombreDescriptivo("Rapel");
		negocioActividad.crearActividad(actividad);
		Registro registro= new Registro();
		registro.setDescripcion("Tecnica de descenso rapido en paredes. ");
		registro.setTipo("Extremo");
		negocioRegistro.registrarActividad(1L,actividad);

		Assert.assertNotNull(actividad);

	}
	@Test
	public void listarRegistro(){
		Empresa em=new Empresa();
		em.setRazonSocial("PLAZA VEA ORIENTE S.A.C.");
		em.setNombreComercial("Plaza Vea");
		em.setRuc("20601233488");
		em.setCorreoinfo("---");
		em.setTelefono("99999999");
		em.setWeb("https://www.plazavea.com.pe/");
		em.setDireccion("AV. CENTENARIO MZA. 365 LOTE. 16 UCAYALI - CORONEL PORTILLO - YARINACOCHA");
		em.setProvincia("UCAYALI");
		em.setDepartamento("YARINACOCHA");
		em.setDistrito("-----");
		negocioEmpresa.crearEmpresa(em);
		Actividad actividad=new Actividad();
		actividad.setNombreDescriptivo("Motocros");
		actividad.setDescripcion("Manejar motos a gra nvelocidad");
		actividad.setTipo("Extremo");
		negocioActividad.crearActividad(actividad);

		Registro r =new Registro();

		negocioRegistro.registrarActividad(em,actividad);

	}*/
	@Test
	public void listarRegistros(){
		Iterable<Registro> re=negocioRegistro.ObtenerRegistros();
		for(Registro r:re){
			System.out.println(r.getActividad().getNombreDescriptivo());
			System.out.println(r.getEmpresa().getNombreComercial());
			System.out.println(r.getCodigo());
		}
	}
	@Test
	public void ListarEmpreas(){
		Iterable<Empresa> empresas = negocioEmpresa.obtenerEmpresas();
		for(Empresa e:empresas){
			System.out.println(e.getRazonSocial());
			System.out.println(e.getRuc());
			System.out.println(e.getCodigo());
		}
	}
}
