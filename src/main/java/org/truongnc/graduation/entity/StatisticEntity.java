package org.truongnc.graduation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;

@Entity(name = "Statistic")
@Table(name = "statistic")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StatisticEntity {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String sbd;
    private String toan;
    private String van;
    private String anh;

    private String ly;
    private String hoa;
    private String sinh;

    private String tbKhtn;

    private String gdcd;
    private String su;
    private String dia;

    private String tbKhxh;

    public String buildScoreString() {
        StringBuilder result = new StringBuilder();

        if (toan != null) {
            result.append("Môn Toán ").append(toan).append(" | ");
        }
        if (van != null) {
            result.append("Môn Văn ").append(van).append(" | ");
        }
        if (anh != null) {
            result.append("Môn Anh ").append(anh).append(" | ");
        }
        if (ly != null) {
            result.append("Môn Lý ").append(ly).append(" | ");
        }
        if (hoa != null) {
            result.append("Môn Hóa ").append(hoa).append(" | ");
        }
        if (sinh != null) {
            result.append("Môn Sinh ").append(sinh).append(" | ");
        }
        if (tbKhtn != null) {
            result.append("TB KHTN ").append(tbKhtn).append(" | ");
        }
        if (gdcd != null) {
            result.append("Môn GDCD ").append(gdcd).append(" | ");
        }
        if (su != null) {
            result.append("Môn Sử ").append(su).append(" | ");
        }
        if (dia != null) {
            result.append("Môn Địa ").append(dia).append(" | ");
        }
        if (tbKhxh != null) {
            result.append("TB KHXH ").append(tbKhxh).append(" | ");
        }

        // Xóa ký tự " | " cuối cùng nếu chuỗi không rỗng
        if (result.length() > 0) {
            result.setLength(result.length() - 3);
        }

        return result.toString();
    }

}