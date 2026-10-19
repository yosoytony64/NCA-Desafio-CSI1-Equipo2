using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse.test
{
    [TestFixture]
    public class GestorJugadaTests
    {
        [Test]
        public void ConfirmarApuesta_MontoValido_Test()
        {
            
            var gestor = new GestorJugada(1000.0);

            
            bool primerClic = gestor.ConfirmarApuesta(400.0, "Morado");
            bool segundoClic = gestor.ConfirmarApuesta(400.0, "Morado"); 

            // Assert
            Assert.True(primerClic);
            Assert.False(segundoClic); 
            Assert.AreEqual(600.0, gestor.Saldo); 
        }

        [TestCase(1000.0, 200.0, 800.0)]
        public void ConfirmarApuesta_MontoValido_TestCase(double saldoInicial, double monto, double saldoEsperado)
        {
            var gestor = new GestorJugada(saldoInicial);
            bool resultado = gestor.ConfirmarApuesta(monto, "Morado");

            Assert.IsTrue(resultado);
            Assert.AreEqual(saldoEsperado, gestor.Saldo);
        }

        [Test]
        public void ConfirmarApuesta_MontoNegativo_Test()
        {
            var gestor = new GestorJugada(1000.0);

            
            bool resultado = gestor.ConfirmarApuesta(-50.0, "Rojo");

            
            Assert.False(resultado);
            Assert.AreEqual(1000.0, gestor.Saldo); // El saldo se mantiene intacto
        }
       
        [TestCase(1000.0, -50.0)]
        public void ConfirmarApuesta_MontoNegativo_TestCase(double saldoInicial, double montoInvalido)
        {
            var gestor = new GestorJugada(saldoInicial);
            bool resultado = gestor.ConfirmarApuesta(montoInvalido, "Rojo");

            Assert.IsFalse(resultado);
            Assert.AreEqual(saldoInicial, gestor.Saldo);
        }

        [Test]
        public void ConfirmarApuesta_SaldoInsuficiente_Test()
        {
            
            var gestor = new GestorJugada(100.0); // Tiene 100

           
            bool resultado = gestor.ConfirmarApuesta(500.0, "Verde"); // Quiere apostar 500

           
            Assert.False(resultado);
        }

        [TestCase(100.0, 500.0, "Verde")]
        public void ConfirmarApuesta_SaldoInsuficiente_TestCase(double saldoInicial, double montoApuesta, string caballo)
        {
            // Arrange
            var gestor = new GestorJugada(saldoInicial); // Tiene 100

            // Act
            bool resultado = gestor.ConfirmarApuesta(montoApuesta, caballo); // Quiere apostar 500

            // Assert
            Assert.IsFalse(resultado);
        }


        [TestCase(1000.0, 0.0)]
        public void ConfirmarApuesta_MontoCero_TestCase(double saldoInicial, double montoInvalido)
        {
            var gestor = new GestorJugada(saldoInicial);
            bool resultado = gestor.ConfirmarApuesta(montoInvalido, "Rojo");

            Assert.IsFalse(resultado);
            Assert.AreEqual(saldoInicial, gestor.Saldo);
        }

        [Test]
        public void ConfirmarApuesta_MontoMayorAlSaldo_Test()
        {
            // Arrange
            double saldoInicial = 1000.0;
            double montoInvalido = 1500.0;
            var gestor = new GestorJugada(saldoInicial);

            // Act
            bool resultado = gestor.ConfirmarApuesta(montoInvalido, "Rojo");

            // Assert
            Assert.IsFalse(resultado);
            Assert.AreEqual(saldoInicial, gestor.Saldo);
        }

        [TestCase(1000.0, 1500.0)]
        public void ConfirmarApuesta_MontoMayorAlSaldo_TestCase(double saldoInicial, double montoInvalido)
        {
            var gestor = new GestorJugada(saldoInicial);
            bool resultado = gestor.ConfirmarApuesta(montoInvalido, "Rojo");

            Assert.IsFalse(resultado);
            Assert.AreEqual(saldoInicial, gestor.Saldo);
        }

        [Test]
        public void ConfirmarApuesta_CaballoVacio_Test()
        {
          var gestor = new GestorJugada(1000.0);
            string caballoInvalido = "";

            bool resultado = gestor.ConfirmarApuesta(100.0, caballoInvalido);

            Assert.IsFalse(resultado);
            Assert.AreEqual(1000.0, gestor.Saldo);
        }
       
        [TestCase("")]
        public void ConfirmarApuesta_CaballoVacio_TestCase(string caballoInvalido)
        {
            var gestor = new GestorJugada(1000.0);
            bool resultado = gestor.ConfirmarApuesta(100.0, caballoInvalido);

            Assert.IsFalse(resultado);
            Assert.AreEqual(1000.0, gestor.Saldo);
        }
    }
}
