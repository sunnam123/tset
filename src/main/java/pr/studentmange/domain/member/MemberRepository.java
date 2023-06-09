package pr.studentmange.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository implements MemberInterface{
    private static Map<Long, Member> store= new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(Long id){
        return store.get(id);
    }



    public List<Member> findALL(){
        return new ArrayList<>(store.values());
    }



    @Override
    public Optional<Member> findByLoginId(String loginId){
        return findALL().stream().filter(m->m.getLoginId().equals(loginId)).findFirst();

    }

    @Override
    public Optional<Member> findByName(String name){
        return findALL().stream().filter(m->m.getName().equals(name)).findFirst();
    }




}
