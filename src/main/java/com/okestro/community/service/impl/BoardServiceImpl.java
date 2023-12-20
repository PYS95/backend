package com.okestro.community.service.impl;

import com.okestro.community.model.ListDto;
import com.okestro.community.service.BoardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {
    private final List<ListDto> listDtoMember = new ArrayList<>();

    public BoardServiceImpl() {

        ListDto listDto1 = new ListDto();
        listDto1.setId(1L);
        listDto1.setTitle("개발자의 삶");
        listDto1.setName("김철수");
        listDto1.setContent("안녕하세요. 저는 웹 개발자로 일하고 있는 김철수입니다. 오늘은 Vue.js를 사용하여 프로젝트를 진행하고 있습니다. Vue.js는 정말 간편하면서도 강력한 프레임워크인 것 같습니다. 여러분은 어떤 기술을 사용하고 계신가요?");
        this.listDtoMember.add(listDto1);

        ListDto listDto2 = new ListDto();
        listDto2.setId(2L);
        listDto2.setTitle("여행이야기");
        listDto2.setName("이영희");
        listDto2.setContent("여름 휴가를 맞아 해외로 여행을 다녀왔어요. 그냥 가볍게 즐기려고 했는데, 예상치 못한 모험이 있었습니다. 고장 난 렌트카, 길을 잃은 일정, 그리고 예약하지 않은 호텔에서의 머무름 등등... 여행 이야기를 공유하고 싶어졌어요.");
        this.listDtoMember.add(listDto2);

        ListDto listDto3 = new ListDto();
        listDto3.setId(3L);
        listDto3.setTitle("코딩 일기");
        listDto3.setName("박지원");
        listDto3.setContent("오늘은 어려운 버그를 해결하는 데 성공했습니다. 여러분들도 코딩 중에 어려움을 겪고 있다면 함께 해결해봐요!");
        this.listDtoMember.add(listDto3);

        ListDto listDto4 = new ListDto();
        listDto4.setId(4L);
        listDto4.setTitle("맛집 탐방");
        listDto4.setName("김맛있어");
        listDto4.setContent("지난 주말에 다녀온 맛집을 소개합니다. 맛있는 음식과 함께한 시간은 언제나 행복해요. 다들 자신의 맛집 소개해주세요!");
        this.listDtoMember.add(listDto4);

        ListDto listDto5 = new ListDto();
        listDto5.setId(5L);
        listDto5.setTitle("운동 일지");
        listDto5.setName("이스트레스아웃");
        listDto5.setContent("스트레스 해소를 위해 매일 조깅을 시작했습니다. 체력 향상과 스트레스 해소에 탁월한 효과가 있어요. 함께 운동하는 동료를 찾습니다!");
        this.listDtoMember.add(listDto5);

        ListDto listDto6 = new ListDto();
        listDto6.setId(6L);
        listDto6.setTitle("독서 감상");
        listDto6.setName("김독서");
        listDto6.setContent("최근에 읽은 책 중에서 인상 깊은 구절을 공유합니다. 여러분도 추천 도서가 있다면 나눠주세요!");
        this.listDtoMember.add(listDto6);

        ListDto listDto7 = new ListDto();
        listDto7.setId(7L);
        listDto7.setTitle("게임 이야기");
        listDto7.setName("박게이머");
        listDto7.setContent("최근에 플레이한 게임 중에서 재밌었던 게임을 소개합니다. 다같이 이야기 나눠요!");
        this.listDtoMember.add(listDto7);

        ListDto listDto8 = new ListDto();
        listDto8.setId(8L);
        listDto8.setTitle("음악 감상");
        listDto8.setName("이음악중독");
        listDto8.setContent("좋아하는 음악을 듣는 것만으로 기분이 좋아지는 이야기를 나눠봐요. 여러분의 플레이리스트도 궁금해요!");
        this.listDtoMember.add(listDto8);

        ListDto listDto9 = new ListDto();
        listDto9.setId(9L);
        listDto9.setTitle("여름 휴가 계획");
        listDto9.setName("최휴가");
        listDto9.setContent("올해 여름 휴가 계획을 세우고 있는데, 여러분들은 어떤 계획이 있나요? 함께 이야기 나눠요!");
        this.listDtoMember.add(listDto9);

        ListDto listDto10 = new ListDto();
        listDto10.setId(10L);
        listDto10.setTitle("취미 공유");
        listDto10.setName("김취미러");
        listDto10.setContent("저는 주말에 그림 그리기를 즐깁니다. 여러분들의 취미도 궁금해요. 취미를 공유해주세요!");
        this.listDtoMember.add(listDto10);

        ListDto listDto11 = new ListDto();
        listDto11.setId(11L);
        listDto11.setTitle("휴식의 시간");
        listDto11.setName("이휴식");
        listDto11.setContent("매주 토요일은 나만의 휴식의 날로 정해놓고 즐기고 있어요. 여러분들은 어떻게 휴식을 취하시나요?");
        this.listDtoMember.add(listDto11);

        ListDto listDto12 = new ListDto();
        listDto12.setId(12L);
        listDto12.setTitle("공부 습관");
        listDto12.setName("김공부");
        listDto12.setContent("공부를 하는데 효과적인 방법이 있다면 공유해주세요. 함께 습관을 만들어 나가요!");
        this.listDtoMember.add(listDto12);

        ListDto listDto13 = new ListDto();
        listDto13.setId(13L);
        listDto13.setTitle("반려동물 이야기");
        listDto13.setName("박펫러");
        listDto13.setContent("최근에 입양한 강아지와의 즐거운 일상을 공유합니다. 여러분들도 반려동물과의 소소한 이야기를 나눠주세요!");
        this.listDtoMember.add(listDto13);

        ListDto listDto14 = new ListDto();
        listDto14.setId(14L);
        listDto14.setTitle("가볍게 산책");
        listDto14.setName("김산책");
        listDto14.setContent("매일 저녁 가볍게 산책하는 것이 즐거운 시간입니다. 산책 이야기를 나눠봐요!");
        this.listDtoMember.add(listDto14);

        ListDto listDto15 = new ListDto();
        listDto15.setId(15L);
        listDto15.setTitle("주말 드라이브");
        listDto15.setName("이드라이브");
        listDto15.setContent("주말마다 가족과 함께하는 드라이브는 기분 전환에 딱이에요. 여러분들도 좋아하는 드라이브 코스가 있다면 알려주세요!");
        this.listDtoMember.add(listDto15);

        ListDto listDto16 = new ListDto();
        listDto16.setId(16L);
        listDto16.setTitle("영화 감상 중");
        listDto16.setName("김영화");
        listDto16.setContent("요즘 영화를 많이 보는 중입니다. 함께 좋은 영화 추천하고 이야기 나눠요!");
        this.listDtoMember.add(listDto16);

        ListDto listDto17 = new ListDto();
        listDto17.setId(17L);
        listDto17.setTitle("음악 감상 중");
        listDto17.setName("이음악");
        listDto17.setContent("좋아하는 음악을 듣는 것을 즐깁니다. 함께 음악 이야기를 나눠요!");
        this.listDtoMember.add(listDto17);

        ListDto listDto18 = new ListDto();
        listDto18.setId(18L);
        listDto18.setTitle("요리 이야기");
        listDto18.setName("최요리");
        listDto18.setContent("최근에 시도한 레시피 중에서 맛있게 만든 음식을 소개합니다. 다들 자신의 요리 이야기를 나눠주세요!");
        this.listDtoMember.add(listDto18);

        ListDto listDto19 = new ListDto();
        listDto19.setId(19L);
        listDto19.setTitle("일상 이야기");
        listDto19.setName("박일상");
        listDto19.setContent("매일매일의 소소한 일상을 공유하고 싶어졌어요. 여러분들도 나만의 소중한 순간을 나눠주세요!");
        this.listDtoMember.add(listDto19);

        ListDto listDto20 = new ListDto();
        listDto20.setId(20L);
        listDto20.setTitle("테크 트렌드");
        listDto20.setName("김테크");
        listDto20.setContent("최근의 테크 트렌드와 관련된 이야기를 나눠봐요. 여러분들은 어떤 기술 동향에 관심이 있나요?");
        this.listDtoMember.add(listDto20);
    }

    @Override
    public List<ListDto> boardlist() {

//        String[] title = {
//                "개발자의 삶",
//                "여행이야기",
//                "코딩 일기",
//                "맛집 탐방",
//                "운동 일지",
//                "독서 감상",
//                "게임 이야기",
//                "음악 감상",
//                "여름 휴가 계획",
//                "취미 공유",
//                "휴식의 시간",
//                "공부 습관",
//                "반려동물 이야기",
//                "가볍게 산책",
//                "주말 드라이브",
//                "영화 감상 중",
//                "음악 감상 중",
//                "요리 이야기",
//                "일상 이야기",
//                "테크 트렌드"
//        };
//
//        String[] name = {
//                "김철수",
//                "이영희",
//                "박지원",
//                "김맛있어",
//                "이스트레스아웃",
//                "김독서",
//                "박게이머",
//                "이음악중독",
//                "최휴가",
//                "김취미러",
//                "이휴식",
//                "김공부",
//                "박펫러",
//                "김산책",
//                "이드라이브",
//                "김영화",
//                "이음악",
//                "최요리",
//                "박일상",
//                "김테크"
//        };
//
//        String[] content = {
//                "안녕하세요. 저는 웹 개발자로 일하고 있는 김철수입니다. 오늘은 Vue.js를 사용하여 프로젝트를 진행하고 있습니다. Vue.js는 정말 간편하면서도 강력한 프레임워크인 것 같습니다. 여러분은 어떤 기술을 사용하고 계신가요?",
//                "여름 휴가를 맞아 해외로 여행을 다녀왔어요. 그냥 가볍게 즐기려고 했는데, 예상치 못한 모험이 있었습니다. 고장 난 렌트카, 길을 잃은 일정, 그리고 예약하지 않은 호텔에서의 머무름 등등... 여행 이야기를 공유하고 싶어졌어요.",
//                "오늘은 어려운 버그를 해결하는 데 성공했습니다. 여러분들도 코딩 중에 어려움을 겪고 있다면 함께 해결해봐요!",
//                "지난 주말에 다녀온 맛집을 소개합니다. 맛있는 음식과 함께한 시간은 언제나 행복해요. 다들 자신의 맛집 소개해주세요!",
//                "스트레스 해소를 위해 매일 조깅을 시작했습니다. 체력 향상과 스트레스 해소에 탁월한 효과가 있어요. 함께 운동하는 동료를 찾습니다!",
//                "최근에 읽은 책 중에서 인상 깊은 구절을 공유합니다. 여러분도 추천 도서가 있다면 나눠주세요!",
//                "최근에 플레이한 게임 중에서 재밌었던 게임을 소개합니다. 다같이 이야기 나눠요!",
//                "좋아하는 음악을 듣는 것만으로 기분이 좋아지는 이야기를 나눠봐요. 여러분의 플레이리스트도 궁금해요!",
//                "올해 여름 휴가 계획을 세우고 있는데, 여러분들은 어떤 계획이 있나요? 함께 이야기 나눠요!",
//                "저는 주말에 그림 그리기를 즐깁니다. 여러분들의 취미도 궁금해요. 취미를 공유해주세요!",
//                "매주 토요일은 나만의 휴식의 날로 정해놓고 즐기고 있어요. 여러분들은 어떻게 휴식을 취하시나요?",
//                "공부를 하는데 효과적인 방법이 있다면 공유해주세요. 함께 습관을 만들어 나가요!",
//                "최근에 입양한 강아지와의 즐거운 일상을 공유합니다. 여러분들도 반려동물과의 소소한 이야기를 나눠주세요!",
//                "매일 저녁 가볍게 산책하는 것이 즐거운 시간입니다. 산책 이야기를 나눠봐요!",
//                "주말마다 가족과 함께하는 드라이브는 기분 전환에 딱이에요. 여러분들도 좋아하는 드라이브 코스가 있다면 알려주세요!",
//                "요즘 영화를 많이 보는 중입니다. 함께 좋은 영화 추천하고 이야기 나눠요!",
//                "좋아하는 음악을 듣는 것을 즐깁니다. 함께 음악 이야기를 나눠요!",
//                "최근에 시도한 레시피 중에서 맛있게 만든 음식을 소개합니다. 다들 자신의 요리 이야기를 나눠주세요!",
//                "매일매일의 소소한 일상을 공유하고 싶어졌어요. 여러분들도 나만의 소중한 순간을 나눠주세요!",
//                "최근의 테크 트렌드와 관련된 이야기를 나눠봐요. 여러분들은 어떤 기술 동향에 관심이 있나요?"
//        };
//
//        for (int i = 0; i < 20; i++) {
//            ListDto listDto = new ListDto();
//            listDto.setId((long) (i + 1));
//
//            listDto.setTitle(titles[i]);
//            listDto.setName(names[i]);
//            listDto.setContent(contents[i]);
//
//            listDto.setCommentCount(0);
//            listDto.setComments(new ArrayList<>()); // 댓글 리스트 초기화
//            listDtoMember.add(listDto);
//        }
        return listDtoMember;
    }

    @Override
    public ListDto getBoardById(Long id) {

        try {
            return listDtoMember.stream()
                    .filter(listDto -> listDto.getId().equals(id))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("ListDto not found for id: " + id));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

