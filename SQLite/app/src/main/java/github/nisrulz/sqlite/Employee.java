package github.nisrulz.sqlite;

public class Employee {

    private int _id;
    private String _name;
    private String _address;
    private String _phone;

    public Employee() {

    }

    public Employee(int id, String name, String address, String phone) {
        this._id = id;
        this._name = name;
        this._address = address;
        this._phone = phone;
    }

    public Employee(String name, String address, String phone) {
        this._name = name;
        this._address = address;
        this._phone = phone;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public String get_phone() {
        return _phone;
    }

    public void set_phone(String _phone) {
        this._phone = _phone;
    }
}
