package MT251.TMA;

public class Schedule extends Course {
    private String period;

    public Schedule() {
        this(null, 0, null);
    }

    Schedule(String courseCode, int creditHours, String period) {
        super(courseCode, creditHours);
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + "Period: " + this.getPeriod();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Schedule)
            if (super.equals(o))
                return this.getPeriod().equals(((Schedule) o).getPeriod());
        return false;
    }
}
