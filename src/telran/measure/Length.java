package telran.measure;

import java.text.NumberFormat;
import java.util.Locale;

public class Length implements Comparable<Length> {
	private final float amount;
	private final LengthUnit unit;

	public Length(float amount, LengthUnit unit) {
		this.amount = amount;
		this.unit = unit;
	}

	@Override
	public boolean equals(Object obj) {
		return this.compareTo((Length) obj) == 0 ? true : false;
	}

	@Override
	public int compareTo(Length o) {
		return Float.compare(amount * unit.value, o.amount * o.unit.value);
	}

	public Length convert(LengthUnit unit) {
		return new Length(amount * this.unit.value / unit.value, unit);
	}

	public String toString() {
		return "" + NumberFormat.getNumberInstance(Locale.US).format(amount) + unit;
	}

	public float getAmount() {
		return amount;
	}

	public LengthUnit getUnit() {
		return unit;
	}

}
