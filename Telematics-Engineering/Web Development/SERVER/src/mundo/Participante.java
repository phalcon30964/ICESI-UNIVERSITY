package mundo;

public class Participante {
	
		private String rum;
		
		private String tel;
		
		private int tipo;
		
		
		public String getRum() {
			return rum;
		}
		public void setRum(String rum) {
			this.rum = rum;
		}
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public int getTipo() {
			return tipo;
		}
		public void setTipo(int tipo) {
			this.tipo = tipo;
		}
		public Participante(String rum, String tel, int tipo) {
			
			this.rum = rum;
			this.tel = tel;
			this.tipo = tipo;

		
		
	}

}
