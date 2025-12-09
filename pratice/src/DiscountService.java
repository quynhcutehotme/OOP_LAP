package ocp2;

import java.util.HashMap;
import java.util.Map;

public class DiscountService{
    public Map<String, DiscountPolicy> discountPolicies = new HashMap<>();
    public DiscountService() {
        discountPolicies.put("STUDENT", new StudentPolicy());
        discountPolicies.put("TEACHER", new TeacherPolicy());
        discountPolicies.put("VIP", new VipPolicy());
    }
    public void addPolicy(String code, DiscountPolicy policy) {
        discountPolicies.put(code, policy);
    }

    public double applyDiscount(String code, double totalPrice) {
        DiscountPolicy policy = discountPolicies.get(code);
        if (policy != null) {
            return policy.discount(totalPrice);
        }
        return totalPrice;
    }
    public boolean hasPolicy(String code) {
        return discountPolicies.containsKey(code);
    }
}


interface DiscountPolicy {
    public double discount(double totalPrice);
}

class StudentPolicy implements DiscountPolicy{
    @Override
    public double discount(double totalPrice){
        return totalPrice * 0.15;
    }
}

class TeacherPolicy implements DiscountPolicy{
    @Override
    public double discount(double totalPrice){
        return totalPrice * 0.2;
    }
}

class VipPolicy implements DiscountPolicy{
    @Override
    public double discount(double totalPrice){
        return totalPrice * 0.25;
    }
}

class AlumniPolicy implements DiscountPolicy{
    @Override
    public double discount(double totalPrice){
        return totalPrice * 0.1;
    }
}



class tetsDiscount {
    public static void main(String[] args) {
        DiscountService service = new DiscountService();
        double price = 1000;
        System.out.println("Student: " + service.applyDiscount("STUDENT", price));
        System.out.println("Teacher: " + service.applyDiscount("TEACHER", price));
        System.out.println("VIP: " + service.applyDiscount("VIP", price));
        System.out.println("Origin price: " + service.applyDiscount("NONE", price));
        service.addPolicy("Alumni", new AlumniPolicy());
        System.out.println("Alumni: " + service.applyDiscount("Alumni", price));

    }
}