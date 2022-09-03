package telran.measure;

public enum LengthUnit {
	MM(1f), CM(10f), IN(25.4f), FT(304.8f), M(1000f), KM(1000000f);

	float value;

	private LengthUnit(float value) {
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	public Length between(Length l1, Length l2) {
		float amountInMm1 = l1.getAmount() * l1.getUnit().value;
		float amountInMm2 = l2.getAmount() * l2.getUnit().value;
		if (amountInMm1 < amountInMm2) {
			float temp = amountInMm1;
			amountInMm1 = amountInMm2;
			amountInMm2 = temp;
		}
		return new Length((amountInMm1 - amountInMm2) / this.value, this);
	}
}
