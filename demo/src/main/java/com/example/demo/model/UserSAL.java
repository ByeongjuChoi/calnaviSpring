package com.example.demo.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserSAL {
	private String userid;
	private int default_sal;					// 기본급
	private int holyday_sal;					// 법정 휴일 수당	法定休日手当
	private int night_sal;						// 심야 수당		深夜手当
	private int career_sal;						// 업무 수당		職能手当
	private int skill_sal;						// 기술 수당		技術手当
	private int special_sal;					// 특별 수당		特別手当
	private int commute_sal;					// 통근 수당		通勤手当
	private int housing_sal;					// 주택 수당		住宅手当
	private int other_taxation_sal;				// 기타 과세		その他課税
	private int telework_sal;					// 텔레워크 수당	テレワーク手当
	private int other_nontaxable;				// 기타 비과세		その他非課税
	private int expense_adjustment_sal;			// 경비 정산		経費精算
	private int lateness_deduction;				// 지각 공제		遅刻控除
	private int absenteeism_deduction;			// 결근 공제		欠勤控除
	private int other_deduction;				// 기타 공제		その他控除
	private int resident_tax;					// 주민세			住民税
	private int social_housing_fee_excluded;	// 사택비 공제		社宅費控除
	private int employment_insurance_premium;	// 고용 보험료		雇用保険料
	private int health_insurance_premium;		// 건강 보험료		健康保険料
	private int welfare_pension_premium;		// 후생 연금 보험료	厚生年金保険料
	private int care_insurance_premium;			// 개호 보험료		介護保険料
	private int withholding_tax;				// 원천 징수		源泉徴収
	private int year_end_adjustment;			// 연말정산액		年末調整額
	private LocalDate updated_at;
}
