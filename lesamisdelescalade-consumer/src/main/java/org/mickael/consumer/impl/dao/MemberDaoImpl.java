package org.mickael.consumer.impl.dao;

import org.mickael.consumer.contract.dao.MemberDao;
import org.mickael.consumer.impl.AbstractDataSource;
import org.mickael.consumer.impl.rowmapper.MemberRowMapper;
import org.mickael.model.bean.Member;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.Types;
import java.util.List;

public class MemberDaoImpl extends AbstractDataSource implements MemberDao {


    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void createMember(Member member) {
        String sql = "INSERT INTO public.member (first_name, last_name, pseudo, birthdate, gender, email, password, role, enabled)"
                             + "VALUES (:firstName, :lastName, :pseudo, :birthdate, :gender, :email, :password, :role, :enabled)";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("birthdate", member.getBirthdate(), Types.DATE);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("role", member.getRole(), Types.VARCHAR);
        parameterSource.addValue("enabled", member.isEnabled(), Types.BOOLEAN);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public Member findMember(Integer id) {
        String sql = "SELECT * FROM public.member WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id, Types.INTEGER);
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        Member member = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, memberRowMapper);

        return member;
    }

    @Override
    public Member findMemberByMail(String email){
        String sql = "SELECT * FROM public.member WHERE email = :email";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("email", email, Types.VARCHAR);
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        try{
            Member member = namedParameterJdbcTemplate.queryForObject(sql, parameterSource, memberRowMapper);
            return member;

        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE public.member SET "
                             + "first_name = :firstName, "
                             + "last_name = :lastName, "
                             + "pseudo = :pseudo, "
                             + "birthdate = :birthdate, "
                             + "gender = :gender, "
                             + "email = :email, "
                             + "password = :password, "
                             + "enabled = :enabled "
                             + "WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("firstName", member.getFirstName(), Types.VARCHAR);
        parameterSource.addValue("lastName", member.getLastName(), Types.VARCHAR);
        parameterSource.addValue("pseudo", member.getPseudo(), Types.VARCHAR);
        parameterSource.addValue("birthdate", member.getBirthdate(), Types.TIMESTAMP);
        parameterSource.addValue("gender", member.getGender(), Types.VARCHAR);
        parameterSource.addValue("email", member.getEmail(), Types.VARCHAR);
        parameterSource.addValue("password", member.getPassword(), Types.VARCHAR);
        parameterSource.addValue("enabled", member.isEnabled(), Types.BOOLEAN);


        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public void deleteMember(Integer id) {
        String sql = "DELETE FROM public.member WHERE id = :id";
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        namedParameterJdbcTemplate.update(sql, parameterSource);

    }

    @Override
    public List<Member> findAllMember() {
        String sql = "SELECT * FROM public.member";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        MemberRowMapper memberRowMapper = new MemberRowMapper();
        List<Member> memberList = jdbcTemplate.query(sql, memberRowMapper);

        return memberList;
    }

}
