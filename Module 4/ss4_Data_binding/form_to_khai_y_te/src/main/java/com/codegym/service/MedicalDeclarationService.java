package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MedicalDeclarationService implements IMedicalDeclarationService {
    private static Map<Integer, MedicalDeclaration> medicalDeclarationList;

    static {
        medicalDeclarationList = new HashMap<>();
        medicalDeclarationList.put(1, new MedicalDeclaration(1, "Sy", "2001", "Nam", "Viet Nam", "1900200005319", "Xe buyt", "VN123-45", 40, "20/02/2022", "21/02/2022", "Quang Nam", "Da Nang", "Lien Chieu", "Hoa Minh", "123 Nguyen Tat Thanh", "034567890", "nnh@gmail.com", true, false, false, false, false, false, false, false, false, false));
    }

    @Override
    public List<MedicalDeclaration> showAll() {
        return new ArrayList<>(medicalDeclarationList.values());
    }

    @Override
    public MedicalDeclaration findById(Integer id) {
        return medicalDeclarationList.get(id);
    }

    @Override
    public boolean update(MedicalDeclaration medicalDeclaration) {
        if (medicalDeclarationList.put(medicalDeclaration.getId(), medicalDeclaration) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean create(MedicalDeclaration medicalDeclaration) {
        if (medicalDeclarationList.put(medicalDeclaration.getId(), medicalDeclaration) == null) {
            return true;
        } else {
            return false;
        }
    }
}
