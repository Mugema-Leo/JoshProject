

interface User {
    void register(String identifier1, String identifier2, String password, String name, int age, String gender);
    boolean login(String identifier1, String identifier2);
	void register(String email, String password, String name, int age, String gender);
	boolean login(String phone, String identifier, String password);
}
