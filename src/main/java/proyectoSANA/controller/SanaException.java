package proyectoSANA.controller;

public class SanaException extends RuntimeException{

        String message;   // Missatge per mostrar a la vista
        String errorName;     // Identificador de l’error

        public SanaException()
        {
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getErrorName() {
            return errorName;
        }

        public void setErrorName(String errorName) {
            this.errorName = errorName;
        }
    }


