using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse
{
    public class GestorJugada
    {
        public double Saldo { get; private set; }
        public bool ApuestaConfirmada { get; private set; }

        public GestorJugada(double saldoInicial)
        {
            Saldo = saldoInicial;
            ApuestaConfirmada = false;
        }

        public bool ConfirmarApuesta(double monto, string caballo)
        {
            // Si ya está confirmada, no dejamos volver a clicar (tu error original)
            if (ApuestaConfirmada) return false;

            if (monto <= 0 || monto > Saldo || string.IsNullOrEmpty(caballo))
                return false;

            Saldo -= monto;
            ApuestaConfirmada = true; // Bloqueamos futuros clics
            return true;
        }
    }
}

