package devx.arjun.evaluation.dtos;

public class SecretDto {
    private String name;
    private String value;

    public SecretDto(String n, String v) {
        this.name = n;
        this.value = v;
    }

    public String getValue() {
        return value;
    }
    public String getName() {
        return name;
    }
    public void setValue(String v) {
        this.value = v;
    }
    public void setName(String n) {
        this.name = n;
    }
}
