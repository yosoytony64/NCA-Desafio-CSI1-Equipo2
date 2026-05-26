using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse.test
{
    [TestFixture]
    public class GestorUsuarioTests
    {
        [Test]
        public void Registrar_UsuarioMayorDeEdad_DevuelveTrue()
        {
            
            var gestor = new GestorUsuarios();

         
            bool resultado = gestor.Registrar("Carlos", 22, "carlos@correo.com");

           
            Assert.True(resultado);
        }

        [TestCase("Carlos", 22, "carlos@correo.com")]
        public void Registrar_UsuarioMayorDeEdad_DevuelveTrue(string nombre, int edad, string correo)
        {
            var gestor = new GestorUsuarios();
            bool resultado = gestor.Registrar(nombre, edad, correo);
            Assert.IsTrue(resultado);
        }

        [Test]
        public void Registrar_UsuarioMenorDeEdad_DevuelveFalse()
        {
            
            var gestor = new GestorUsuarios();

            
            bool resultado = gestor.Registrar("Alex", 16, "alex@correo.com");

            
            Assert.False(resultado);
        }

        [TestCase("Alex", 16, "alex@correo.com")]
        public void Registrar_UsuarioMenorDeEdad_DevuelveFalse(string nombre, int edad, string correo)
        {
            var gestor = new GestorUsuarios();
            bool resultado = gestor.Registrar(nombre, edad, correo);
            Assert.IsFalse(resultado);
        }

        [Test]
        public void Registrar_CamposVacios_DevuelveFalse()
        {
            var gestor = new GestorUsuarios();

            
            bool resultado = gestor.Registrar("", 20, "");

            
            Assert.False(resultado);
        }
        [TestCase("", 20, "juan@correo.com")]
        
        public void Registrar_NombreVacio_DevuelveFalse(string nombre, int edad, string correo)
        {
            var gestor = new GestorUsuarios();
            bool resultado = gestor.Registrar(nombre, edad, correo);
            Assert.IsFalse(resultado);
        }

        [Test]
        public void Registrar_EdadLimiteSuperada_DevuelveFalse()
        {
            
            var gestor = new GestorUsuarios();
            string nombre = "Viejo";
            int edad = 105;
            string correo = "v@correo.com";

            
            bool resultado = gestor.Registrar(nombre, edad, correo);

           
            Assert.IsFalse(resultado);
        }

        [TestCase("Viejo", 105, "v@correo.com")]
        public void Registrar_EdadLimiteSuperada_DevuelveFalse(string nombre, int edad, string correo)
        {
            var gestor = new GestorUsuarios();
            bool resultado = gestor.Registrar(nombre, edad, correo);
            Assert.IsFalse(resultado);
        }

        [Test]
        public void Registrar_CorreoVacio_DevuelveFalse()
        {
            // Arrange
            var gestor = new GestorUsuarios();
            string nombre = "Ana";
            int edad = 25;
            string correo = "";

            // Act
            bool resultado = gestor.Registrar(nombre, edad, correo);

            // Assert
            Assert.IsFalse(resultado);
        }


        [TestCase("Ana", 25, "")]
        public void Registrar_CorreoVacio_DevuelveFalse(string nombre, int edad, string correo)
        {
            var gestor = new GestorUsuarios();
            bool resultado = gestor.Registrar(nombre, edad, correo);
            Assert.IsFalse(resultado);
        }

        

       
    }
}

