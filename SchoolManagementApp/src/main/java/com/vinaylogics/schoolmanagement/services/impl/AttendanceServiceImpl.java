package com.vinaylogics.schoolmanagement.services.impl;

import com.vinaylogics.schoolmanagement.models.Attendance;
import com.vinaylogics.schoolmanagement.repositories.AttendanceDao;
import com.vinaylogics.schoolmanagement.repositories.impl.AttendanceDaoImpl;
import com.vinaylogics.schoolmanagement.services.AttendanceService;

import java.util.List;

public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceDao attendanceDao;

    public AttendanceServiceImpl() {
        this.attendanceDao = new AttendanceDaoImpl();
    }

    @Override
    public List<Attendance> findAll() {
        return null;
    }

    @Override
    public Attendance findById(Long aLong) {
        return null;
    }

    @Override
    public Attendance save(Attendance attendance) {
        return null;
    }

    @Override
    public Attendance update(Attendance attendance) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Attendance attendance) {

    }
}
