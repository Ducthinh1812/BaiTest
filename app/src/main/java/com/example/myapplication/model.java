package com.example.myapplication;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "table")
public class model {

        @PrimaryKey(autoGenerate = true)
        public int id;

        public String name;
        public String ngaygio;
        public String ghichu;
        public String color;

    public model() {
    }

    public model(String name, String ngaygio, String ghichu, String color) {
            this.name = name;
            this.ngaygio = ngaygio;
            this.ghichu = ghichu;
            this.color = color;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNgaygio() {
            return ngaygio;
        }

        public void setNgaygio(String ngaygio) {
            this.ngaygio = ngaygio;
        }

        public String getGhichu() {
            return ghichu;
        }

        public void setGhichu(String ghichu) {
            this.ghichu = ghichu;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
