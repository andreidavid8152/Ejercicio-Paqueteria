import java.util.ArrayList;
import java.util.List;

public class TrackingSystem {
    private List<Package> packages;
    private int nPackage;

    public TrackingSystem(){
        packages = new ArrayList<>();
        nPackage = 0;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public int getnPackage() {
        return nPackage;
    }

    public void addPackage(Package p){
        nPackage += 1;
        packages.add(p);
    }

    public boolean removePackage(String trackingNumber){
        return searchByTrackingNumberSecuencial(trackingNumber);
    }

    public boolean searchByTrackingNumberSecuencial(String trackingNumber){
        for(int i = 0; i < packages.size(); i++){
            if(packages.get(i).getTrackingNumber().equals(trackingNumber)){
                packages.remove(i);
                return true;
            }
        }
        return false;
    }

    public Package searchByRecipientAddress(String street, String city, String state, String zipCode){
        for(int i = 0; i < packages.size(); i++){
            if(packages.get(i).getRecipientAddress().toString().equals(new Address(street, city, state, zipCode).toString())){
                return packages.get(i);
            }
        }
        return null;
    }

    public Package searchByTrackingNumberBinary(String trackingNumber){

        int res = -1;
        int izq = 0;
        int dere = packages.size() - 1;


        while (izq <= dere) {
            int mid = (izq + dere) / 2;

            if (packages.get(mid).getTrackingNumber().equals(trackingNumber)) {
                res = mid;
                return packages.get(res);
            } else if (packages.get(mid).getTrackingNumber().compareTo(trackingNumber) < 0) {
                izq = mid + 1;
            } else {
                dere = mid - 1;
            }
        }

        return null;
    }

    public List<Package> searchByCity(String city){

        List<Package> pCiudad = new ArrayList<>();

        for(int i = 0; i < packages.size(); i++){
            if(packages.get(i).getRecipientAddress().getCity().equals(city)){
                pCiudad.add(packages.get(i));
            }
        }

        return pCiudad;
    }

    public List<Package> searchByState(String state){

        List<Package> pEstado = new ArrayList<>();

        for(int i = 0; i < packages.size(); i++){
            if(packages.get(i).getRecipientAddress().getState().equals(state)){
                pEstado.add(packages.get(i));
            }
        }

        return pEstado;
    }

    public List<Package> searchByCP(String cp){

        List<Package> pCP = new ArrayList<>();

        for(int i = 0; i < packages.size(); i++){
            if(packages.get(i).getRecipientAddress().getZipCode().equals(cp)){
                pCP.add(packages.get(i));
            }
        }

        return pCP;
    }



}
