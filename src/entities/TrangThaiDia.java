package entities;

public enum TrangThaiDia {
	sanSangChoThue{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Sẵn sàng cho thuê";
		}
	},
	daThue{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return"Đã thuê";
		}
	},
	daGan{
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Đã Gán";
		}
	}
}
