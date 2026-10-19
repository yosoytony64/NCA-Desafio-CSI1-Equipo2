using System;
using System.Collections.Generic;
using System.Text;

namespace Winshorse
{
    public class GestorUsuarios
    {
        
        public bool Registrar(string nombre, int edad, string correo)
        {
            if (string.IsNullOrWhiteSpace(nombre) || string.IsNullOrWhiteSpace(correo))
                return false;

            if (edad < 18 || edad > 100)
                return false;

            return true; // Registro correcto
        }
    }
}

