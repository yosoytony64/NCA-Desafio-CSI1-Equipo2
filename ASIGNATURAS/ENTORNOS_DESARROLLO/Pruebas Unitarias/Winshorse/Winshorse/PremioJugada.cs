using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse
{
    public class PremioJugada
    {
        public double ProcesarResultado(string caballoApostado, double montoApuesta, string caballoGanador, double saldoActual)
        {
            if (caballoApostado == caballoGanador)
            {
                // Si aciertas, te devolvemos tu apuesta multiplicada por 2
                return saldoActual + (montoApuesta * 2);
            }

            // Si pierdes, el saldo se queda igual (porque ya te lo restamos al confirmar)
            return saldoActual;
        }
    }
}
