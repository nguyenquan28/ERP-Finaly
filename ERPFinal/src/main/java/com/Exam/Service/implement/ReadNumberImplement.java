package com.Exam.Service.implement;

import org.springframework.stereotype.Service;

import com.Exam.Service.ReadNumberService;

@Service
public class ReadNumberImplement implements ReadNumberService{

	@Override
	public String docTungChuSo(int n) {
		if(n==0) {
			return " không ";
		}else if(n==1) {
			return " một ";
		}else if(n==2) {
			return " hai ";
		}else if(n==3) {
			return " ba ";
		}else if(n==4) {
			return " bốn ";
		}else if(n==5) {
			return " năm ";
		}else if(n==6) {
			return " sáu ";
		}else if(n==7) {
			return" bảy ";
		}else if(n==8) {
			return " tám ";
		}else  {
			return " chín ";
		}
		
	}

	@Override
	public int demSoLuongChuSo(int n) {
		if(n == 0) return 0;	
		return 1 + demSoLuongChuSo(n/10);
	}

	@Override
	public int daoNguocSo(int n) {
		int soDaoNguoc = 0;
		while(n !=0) {
			soDaoNguoc = soDaoNguoc*10 + n%10;
			n/=10;
		}
		return soDaoNguoc;
	}

	@Override
	public String docSo(int n) {
		int dem = demSoLuongChuSo(n);
		int dao = daoNguocSo(n);
		StringBuilder builder = new StringBuilder();
		while(dao !=0) {
			
			builder.append(docTungChuSo(dao%10));
			if(dem==10) {
				builder.append(" tỷ ");
			}else if(dem==9 || dem==6 || dem == 3)
				builder.append(" trăm ");
			else if(dem==8 || dem == 5 || dem==2) {
				
				builder.append(" mươi ");
			}else if(dem == 7) {
				builder.append(" triệu ");
			}else if(dem == 4 ) {
				builder.append(" nghìn ");
			} 
			
			dem--;
			dao/=10;
			if(dem==1) {
				if(dao%10==1) {
					builder.append(" mốt ");
					break;
				}else if(dao%10==5) {
					builder.append(" lăm ");
					break;
				}
			}
			if(dem == 2 || dem==8 || dem==5) {
				if(dao%10 ==1) {
					builder.append(" mười ");
					dao/=10;
					dem--;
					continue;
				}else if(dao%10 ==0 && dao%100==0) {
					break;
				}else if(dao%10==0) {
					builder.append(" lẻ ");
					dao/=10;
					dem--;
					continue;
				}
				
			}
		}
		
		return builder.toString();
	}

}
