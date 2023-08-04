package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); //싱글톤으로 했기 떄문에 static 없어도 됨
    private static Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {

    }

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findBuId(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 모든 값들을 꺼내, 새로운 리스트에 담아 반환
    }

    public void clearStore() {
        store.clear();
    }
}
