package Negocio.cronometro;

public class Cronometro {

        private long horaInicio;
        private long horaParada;
        private boolean enMarcha;

        // currentTimeMillis() -> tiempo actual en milisegundos.
        
        public Cronometro() {
			
            horaInicio = 0;
            horaParada = 0;
            enMarcha = false;
		}

        public void start() {
                this.horaInicio = System.currentTimeMillis();
                this.enMarcha = true;
        }


        public void stop() {
                this.horaParada = System.currentTimeMillis();
                this.enMarcha = false;
        }


        /**
         * 
         * @returnTiempo transcurrido en milisegundos
         */
        public long getElapsedTime() {
                long tiempoTranscurrido;
                if (enMarcha) {
                        tiempoTranscurrido = (System.currentTimeMillis() - horaInicio);
                }
                else {
                        tiempoTranscurrido = (horaParada - horaInicio);
                }
                return tiempoTranscurrido;
        }
        
        /**
         * 
         * @return tiempo transcurrido en segundos
         */
        public long getElapsedTimeSecs() {
                long tiempoTranscurrido;
                if (enMarcha) {
                        tiempoTranscurrido = ((System.currentTimeMillis() - horaInicio) / 1000);
                }
                else {
                        tiempoTranscurrido = ((horaParada - horaInicio) / 1000);
                }
                return tiempoTranscurrido;
        }
}