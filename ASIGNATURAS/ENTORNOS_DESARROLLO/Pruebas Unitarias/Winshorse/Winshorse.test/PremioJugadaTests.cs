using NUnit.Framework;
using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse.test
{
    [TestFixture]
    public class PremioJugadaTests
    {
        [Test]
        public void ProcesarResultado_CaballoApostadoGana_SumaPremioDoble_Test()
        {
            
            var calculador = new PremioJugada();
            string miCaballo = "Azul";
            string ganadorReal = "Azul"; //Si coincide se suma(ha ganado)
            double apuesta = 200.0;
            double saldoDespuesDeApostar = 800.0;

           
            double saldoFinal = calculador.ProcesarResultado(miCaballo, apuesta, ganadorReal, saldoDespuesDeApostar);

            
            Assert.AreEqual(1200.0, saldoFinal);
        }

        [TestCase("Azul", "Azul", 200.0, 800.0, 1200.0)]
        public void ProcesarResultado_CuandoCaballoApostadoGana_SumaPremioDoble_TestCase(
            string caballoApostado, string caballoGanador, double montoApuesta, double saldoActual, double esperado)
        {
            var calculador = new PremioJugada();
            double saldoFinal = calculador.ProcesarResultado(caballoApostado, montoApuesta, caballoGanador, saldoActual);

            Assert.AreEqual(esperado, saldoFinal);
        }

        [Test]
        public void ProcesarResultado_CaballoApostadoPierde_NoSumaSaldo_Test()
        {
            
            var calculador = new PremioJugada();
            string miCaballo = "Azul";
            string ganadorReal = "Amarillo"; // Perdimos
            double apuesta = 200.0;
            double saldoDespuesDeApostar = 800.0;

            
            double saldoFinal = calculador.ProcesarResultado(miCaballo, apuesta, ganadorReal, saldoDespuesDeApostar);

            
            Assert.AreEqual(800.0, saldoFinal);
        }

        [TestCase("Azul", "Amarillo", 200.0, 800.0, 800.0)]
        public void ProcesarResultado_CuandoCaballoApostadoPierde_MantieneSaldo_TestCase(
            string caballoApostado, string caballoGanador, double montoApuesta, double saldoActual, double esperado)
        {
            var calculador = new PremioJugada();
            double saldoFinal = calculador.ProcesarResultado(caballoApostado, montoApuesta, caballoGanador, saldoActual);

            Assert.AreEqual(esperado, saldoFinal);
        }
    }
}
